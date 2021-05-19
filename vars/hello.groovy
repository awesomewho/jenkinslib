def call(){
  println("hello")
}

// 安装 ansiColor 插件,打印日志
def PrintMessage(value, color){
    colors = ['red' : "\033[40;31n *********** ${value}  *********** \033[0n",
               'blue' : "\033[47;34n *********** ${value} *********** \033[0n",
               'green' : "[1;32m *********** ${value} *********** [n",
               'green1' : "\033[40;32n *********** ${value} *********** \033[0n"
              ]
    ansiColor('xterm') {
        println(colors[color])
    }              
}
