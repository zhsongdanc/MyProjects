package com.demussong.patterndesign.factory.abstractfactory;

import com.demussong.patterndesign.factory.abstractfactory.po.Computer;
import com.demussong.patterndesign.factory.abstractfactory.po.HWPhone;
import com.demussong.patterndesign.factory.abstractfactory.po.MacBook;
import com.demussong.patterndesign.factory.abstractfactory.po.MagicBook;
import com.demussong.patterndesign.factory.abstractfactory.po.Phone;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/10/30 17:02
 */
public  class HWFactory implements IFactory{


    @Override
    public Computer createComputer() {
        return new MagicBook();
    }

    @Override
    public Phone createPhone() {
        return new HWPhone();
    }
}
