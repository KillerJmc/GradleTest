package task;

import groovy.lang.Closure;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认的模拟任务
 * @author Jmc
 */
@SuppressWarnings("rawtypes")
public class DefaultTask implements Task {
    /**
     * 任务链
     */
    Map<String, Closure> closures = new HashMap<>();

    @Override
    public Task configure(Closure c) {
        // 修改委托对象为Task自身！
        // 在闭包中调用方法时，默认委托对象是调用者的this对象
        // 要做到调用者换成Task并能调用里面的方法，需要更换委托对象！
        c.setDelegate(this);

        closures.put("configure", c);
        return this;
    }

    @Override
    public Task doLast(Closure c) {
        // 修改委托对象为Task自身！
        c.setDelegate(this);

        closures.put("doLast", c);
        return this;
    }

    @Override
    public void execute() {
        // 获取配置方法并执行
        var configure = closures.get("configure");
        configure.call();

        // 获取任务执行方法并执行
        var doLast = closures.get("doLast");
        doLast.call();
    }
}
