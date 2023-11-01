package com.demussong.patterndesign.factory.abstractfactory;

import com.demussong.patterndesign.factory.abstractfactory.po.Computer;
import com.demussong.patterndesign.factory.abstractfactory.po.Phone;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/10/30 16:56
 */
public interface IFactory {

    public Computer createComputer();

    public Phone createPhone();
}
