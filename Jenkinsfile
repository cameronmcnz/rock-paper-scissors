node { 
	def prefix= ''
	if (isUnix()) 
		prefix = '~/setup/git/';
	else 
		prefix = 'c:\\setup\\git\\';
	def mvnHome = tool 'Maven 3.3.9'
	def tomcatWeb = ''
	def mvnBin = mvnHome
	if (isUnix()) {
		tomcatWeb = '/Library/Tomcat/webapps'
		mvnBin+='/bin'
		}
	else { 
		tomcatWeb = 'C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps'	
		mvnBin+='\\bin'
		}
	stage('jpa') { 

	 ws('wsjpa') {
			git url: "${prefix}/course-jpa"
			withEnv(["JAVA_HOME=${ tool 'JDK 8' }","PATH+MAVEN=${mvnBin}"]) {
			if (isUnix()) 
				sh "mvn clean install"
			else {
				bat "mvn clean install"
				}
				}
			 stash name: "jpa-jar", includes: "target/course-jpa*.jar"	
		}
		}
	stage('jsf') { 
	 ws('wsjsf') {
			git url: "${prefix}/course-jsf"
			withEnv(["JAVA_HOME=${ tool 'JDK 8' }","PATH+MAVEN=${mvnBin}"]) {
			if (isUnix()) {
				sh "mvn clean install"
				sh "cp target/course-jsf*.war ${tomcatWeb}/course-jsf.war"
				}
			else {
				bat "mvn clean install"
				bat "copy target\\course-jsf*.war \"${tomcatWeb}\\course-jsf.war\""
				}
				}
			
		}
		}
	stage('web') {
	 ws('wsweb') {
			git url: "${prefix}/course-web"
			withEnv(["JAVA_HOME=${ tool 'JDK 8' }","PATH+MAVEN=${mvnBin}"]) {
			if (isUnix()) {
				sh "mvn clean install"
				sh "cp target/course-web*.war ${tomcatWeb}/course-web.war"
				}
			else {
				bat "mvn clean install"
				bat "copy target\\course-web*.war \"${tomcatWeb}\\course-web.war\""
				}
				}
			
		}
	}
	stage ('it-jsf') {
	 ws('wsit-jsf') {
			git url: "${prefix}/course-jsf"
			withEnv(["JAVA_HOME=${ tool 'JDK 8' }","PATH+MAVEN=${mvnBin}"]) {
			if (isUnix()) 
				sh "mvn compiler:testCompile failsafe:integration-test"
			else 
				bat "mvn compiler:testCompile failsafe:integration-test"
				}
			
		}
		
	}
	stage ('it-web') {
	 ws('wsit-web') {
			git url: "${prefix}/course-web"
			withEnv(["JAVA_HOME=${ tool 'JDK 8' }","PATH+MAVEN=${mvnBin}"]) {
			if (isUnix()) 
				sh "mvn compiler:testCompile failsafe:integration-test"
			else 
				bat "mvn compiler:testCompile failsafe:integration-test"
				}
			
		}
		
	}

 }
