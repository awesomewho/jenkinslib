def call(){
  println("hello")
}

// 安装 ansiColor 插件,打印日志
def PrintMessage(value, color){
    colors = ['red' : "\033[40;31m *********** ${value}  *********** \033[0m\n",
              'blue' : "\033[40;34m *********** ${value} *********** \033[0m\n",
              'green' : "\033[40;32m *********** ${value} *********** \033[0m\n"
              ]
    ansiColor('xterm') {
        println(colors[color])
    }              
}
