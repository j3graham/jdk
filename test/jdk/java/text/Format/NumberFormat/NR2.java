/*
 * Copyright (c) 1997, 2024, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/**
 * @test
 * @bug 4052223 4059870 4061302 4062486 4066646 4068693 4070798 4071005 4071014
 * 4071492 4071859 4074454 4074620 4075713 4083018 4086575 4087244 4087245
 * 4087251 4087535 4088161 4088503 4090489 4090504 4092480 4092561 4095713
 * 4098741 4099404 4101481 4106658 4106662 4106664 4108738 4110936 4122840
 * 4125885 4134034 4134300 4140009 4141750 4145457 4147295 4147706 4162198
 * 4162852 4167494 4170798 4176114 4179818 4185761 4212072 4212073 4216742
 * 4217661 4243011 4243108 4330377 4233840 4241880 4833877 8008577 8227313
 * 8174269
 * @summary Regression tests for NumberFormat and associated classes
 * @library /java/text/testlib
 * @build HexDumpReader TestUtils
 * @modules java.base/sun.util.resources
 *          jdk.localedata
 * @compile -XDignore.symbol.file NumberRegression.java
 * @run junit NR2
 */

/*
(C) Copyright Taligent, Inc. 1996 - All Rights Reserved
(C) Copyright IBM Corp. 1996 - All Rights Reserved

  The original version of this source code and documentation is copyrighted and
owned by Taligent, Inc., a wholly-owned subsidiary of IBM. These materials are
provided under terms of a License Agreement between Taligent and Sun. This
technology is protected by multiple US and International patents. This notice and
attribution to Taligent may not be removed.
  Taligent is a registered trademark of Taligent, Inc.
*/

import org.junit.jupiter.api.Test;
import sun.util.resources.LocaleData;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.fail;

public class NR2 {


    @Test
    public void Test4134300() {
        Locale savedLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);
        Object[] DATA = {
                // Pattern      Expected string
                1000d,      "1000.00",
                1e-2,      "0.01",
                1234.5,      "1234.50",
                1234,      "1234.00",
                5.0,      "5.00",
                -1e-4,      "-0.00",
                1e11,      "100000000000.00",
                0.0099,    "0.01",
                0.001, "0.00",
                1.001, "1.00",
                1.006, "1.01",
//                0.006, "0.01", //FAIL

        };
        for (int i=0; i<DATA.length; i+=2) {
            String result = new DecimalFormat("0.00").format(DATA[i]);
            if (!result.equals(DATA[i+1])) {
                fail("Fail: " + DATA[i] + " = " + result +
                        "; want " + DATA[i+1]);
            }
            else {
                System.out.println("Ok: " + DATA[i] + " = " + result);
            }
        }
        Locale.setDefault(savedLocale);
    }


}


