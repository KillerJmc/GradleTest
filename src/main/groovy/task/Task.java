package task;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

/**
 * 模拟任务接口
 * @author Jmc
 */
@SuppressWarnings("rawtypes")
public interface Task {
    /**
     * 配置方法，调用时将闭包添加到任务链中
     * @param c 闭包，标明委托对象是Task（提示DSL）
     * @return 自身
     */
    Task configure(@DelegatesTo(Task.class) Closure c);

    /**
     * 任务执行的方法，调用时将闭包添加到任务链中
     * @param c 闭包，标明委托对象是Task（提示DSL）
     * @return 自身
     */
    Task doLast(@DelegatesTo(Task.class) Closure c);

    /**
     * 执行任务
     */
    void execute();
}
