pipeline{
	agent any
	tools{
		maven 'Maven'
		gradle
		
	
	}
	
	parameters{
		
		choice(name:'VERSION',choices:['1.1.0','1.2.0','1.3.0'],description:'')
		
	}
	environment{
	NEW_VERSION='1.3.0'
	SERVER_CREDENTIALS=credentials('server-credentials')
	}
	
	stages{
		
stage("build"){
steps{
	echo 'building the application'
	echo "building version ${NEW_VERSION}"
	 }}
   
stage("test"){

		steps{
		echo 'testing the applications'
		}}
    
stage("deploy"){
steps{

 echo 'deploying the application'

	echo "deploying version ${params.VERSION}"

}}
	
	post{
		always{
		}
		failue{
		}
	}


}
