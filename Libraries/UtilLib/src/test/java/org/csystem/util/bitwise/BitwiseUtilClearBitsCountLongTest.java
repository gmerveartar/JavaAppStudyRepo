 package org.csystem.util.bitwise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

 @RunWith(Parameterized.class)
 public class BitwiseUtilClearBitsCountLongTest {
     static class DataInfo {
         long val;
         int expected;
         public DataInfo(long val, int expected) {
             this.val = val;
             this.expected = expected;
         }
     }
     public BitwiseUtilClearBitsCountLongTest(DataInfo dataInfo) {
         this.dataInfo = dataInfo;
     }
 
     public DataInfo dataInfo;
     @Parameterized.Parameters
     public static Collection<DataInfo> createData()
     {
         return List.of(new DataInfo(0x0000000000000051, 61),
                 new DataInfo(0x0000000000000041, 62),
                 new DataInfo(0x0000000000000000, 64),
                 new DataInfo(0xFFFFFFFFFFFFFFFFL , 0),
                 new DataInfo(0x8000000000000000L, 63));
     }
     @Test
     public void test()
     {
         Assert.assertEquals(dataInfo.expected, BitwiseUtil.clearBitsCount(dataInfo.val));
     }
 }
