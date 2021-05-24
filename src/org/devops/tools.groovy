package org.devops

// 打印内容
def PrintMes(content){
  println(content)
}

// 安装ansiColor让日志输出颜色
def PrintMessage(value, color){
    colors = ['red' : "\033[40;31m >>>>>>>>>>>>>>>>>> ${value} >>>>>>>>>>>>>>>>>> \033[0m\n",
              'blue' : "\033[40;34m >>>>>>>>>>>>>>>>>> ${value} >>>>>>>>>>>>>>>>>> \033[0m\n",
              'green' : "\033[40;32m >>>>>>>>>>>>>>>>>> ${value} >>>>>>>>>>>>>>>>>> \033[0m\n"
              ]
    ansiColor('xterm') {
        println(colors[color])
    }
}
