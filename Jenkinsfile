// 引用在github建立的共享jinkinslib库
@Library('jenkinslib') _
def tools = new org.devops.tools()

String workspace = "/tmp/jenkins"

pipeline {
// 指定node节点/workspace
agent { node{ label "node1" // 指定运行节点的标签或者名称
               customWorkspace "${workspace}" // 指定运行时的工作目录
    }
}

// 指定运行选项
options {
    // 安装插件Timestamper,否则报错
    timestamps() // 日志中打印时间
    skipDefaultCheckout() // 删除隐式checkout scm语句
    disableConcurrentBuilds() // 禁止并行
    timeout(time: 1, unit: 'HOURS') // 流水线超时设置1h
}

// 指定stages阶段,可以指定一个或者多个
stages {
    // 下载代码
    stage("GetCode"){ // 阶段名称
        steps{  // 步骤
            timeout(time:5, unit:"MINUTES"){ // 步骤超时时间
                script{ // 填写运行代码
                    println('获取代码')
                }
            }
        }
    }

    // 构建
    stage("Build"){
        steps{
            timeout(time:20, unit:"MINUTES"){
                script{
                    println('应用打包')
                }
            }
        }
    }

    // 代码扫描
    stage("CodeScan"){
        steps{
            timeout(time:30, unit:"MINUTES"){
                script{
                    println("代码扫描")
                    // 调用共享库定义的PrintMes函数
                    tools.PrintMes("this is jenkins share library.")
                }
            }
        }
    }
}

// 指定构建后操作
// always{}: 总是执行的脚本片段 success{}: 成功后执行 failure{}: 失败后执行 aborted{}: 取消后执行
// currentBuild 全局变量   description: 构建描述
post {
    always {
        script{
            println("always")
        }
    }

    success {
        script{
            currentBuild.description += "\n 构建成功!"
        }
    }

    failure {
        script{
            currentBuild.description += "\n 构建失败!"
        }
    }

    aborted {
        script{
            currentBuild.description += "\n 构建取消!"
        }
    }

}
}
