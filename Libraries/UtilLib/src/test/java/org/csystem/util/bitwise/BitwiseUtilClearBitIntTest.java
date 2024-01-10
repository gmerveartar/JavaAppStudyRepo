 package org.csystem.util.bitwise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

 @RunWith(Parameterized.class)
 public class BitwiseUtilClearBitIntTest {
     static class DataInfo {
         int val;
         int n;
         int expected;

         public DataInfo(int val, int n, int expected) {
             this.val = val;
             this.n = n;
             this.expected = expected;
         }
     }
     public BitwiseUtilClearBitIntTest(DataInfo dataInfo) {
         this.dataInfo = dataInfo;
     }
 
     public DataInfo dataInfo;
     @Parameterized.Parameters
     public static Collection<DataInfo> createData()
     {
         return List.of(new DataInfo(0x51, 4, 0x41));
     }
     @Test
     public void test()
     {
         Assert.assertEquals(dataInfo.expected, BitwiseUtil.clearBit(dataInfo.val, dataInfo.n));
     }
 }
