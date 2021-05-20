package org.devops

// 构建类型
def Build(buildType, buildShell) {
    def buildTools = ["mvn":"MAVEN","ant":"ANT","gradle":"GRADLE","npm":"NPM"]
    
    println("当前选择的构建类型为  ${buildType}")
    buildHome = tool buildTools[buildType]
    
    if ( "${buildType}" == "npm" ) {
        sh "export NPM_HOME=${buildHome} && export PATH=\$NPM_HOME/bin:\$PATH && (${buildHome}/bin/${buildType} ${buildShell})"
    } 
    
    sh "${buildHome}/bin/${buildType} ${buildShell}"
}
