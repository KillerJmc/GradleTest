package task

/**
 * 创建任务
 * @param taskName 任务名
 * @param configure 任务的配置方法，委托对象是Task
 * @return 任务实例
 */
@SuppressWarnings("unused")
static Task task(String taskName, @DelegatesTo(Task.class) Closure configure) {
    new DefaultTask().configure(configure)
}

static void main(String[] args) {
    // 模拟在gradle中创建任务
    def hello = task("hello") {
        println "正在配置任务：hello"

        doLast {
            println "正在执行任务：hello"
        }
    }

    // 模拟gradle后台
    // 初始化任务
    hello.init()
    // 执行任务
    hello.execute()
}





