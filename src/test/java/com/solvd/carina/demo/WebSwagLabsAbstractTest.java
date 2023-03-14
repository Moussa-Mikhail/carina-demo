package com.solvd.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.utils.SwagLabsLoginUtils;

abstract public class WebSwagLabsAbstractTest implements IAbstractTest {
    protected final SwagLabsLoginUtils loginUtils = new SwagLabsLoginUtils();
}
