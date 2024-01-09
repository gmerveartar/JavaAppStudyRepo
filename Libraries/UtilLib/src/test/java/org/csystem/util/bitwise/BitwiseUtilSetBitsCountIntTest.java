 package org.csystem.util.bitwise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

 @RunWith(Parameterized.class)
 public class BitwiseUtilSetBitsCountIntTest {
     static class DataInfo {
         int val;
         int expected;
         public DataInfo(int val, int expected) {
             this.val = val;
             this.expected = expected;
         }
     }
     public BitwiseUtilSetBitsCountIntTest(DataInfo dataInfo) {
         this.dataInfo = dataInfo;
     }
 
     public DataInfo dataInfo;
     @Parameterized.Parameters
     public static Collection<DataInfo> createData()
     {
         return List.of(new DataInfo(0x51, 3),
                 new DataInfo(0x41, 2),
                 new DataInfo(0x0, 0),
                 new DataInfo(0xFFFFFFFF, 32),
                 new DataInfo(0x80000000, 1 ));
     }
     @Test
     public void test()
     {
         Assert.assertEquals(dataInfo.expected, BitwiseUtil.setBitsCount(dataInfo.val));
     }
 }
