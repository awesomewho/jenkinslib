def call(){
  println("hello")
}

// 安装 ansiColor 插件,打印日志
// 颜色格式：\033[背景;前景\033[0m
// 背景：40 黑色背景 47 白色背景
// 前景：31m 红色 34m 蓝色 32m 绿色
def PrintMessage(value, color){
    colors = ['red' : "\033[40;31m *********** ${value}  *********** \033[0m\n",
              'blue' : "\033[40;34m *********** ${value} *********** \033[0m\n",
              'green' : "\033[40;32m *********** ${value} *********** \033[0m\n"
              ]
    ansiColor('xterm') {
        println(colors[color])
    }              
}
