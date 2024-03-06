 package org.csystem.util.bitwise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

 @RunWith(Parameterized.class)
 public class BitwiseUtilLowestSetBitIndexIntTest {
     static class DataInfo {
         int val;
         int expected;
         public DataInfo(int val,int expected) {
             this.val = val;
             this.expected = expected;
         }
     }
     public BitwiseUtilLowestSetBitIndexIntTest(DataInfo dataInfo) {
         this.dataInfo = dataInfo;
     }

     public DataInfo dataInfo;
     @Parameterized.Parameters
     public static Collection<DataInfo> createData()
     {
         return List.of(new DataInfo(10, 1),
                 new DataInfo(8, 3),
                 new DataInfo(0, -1)
         );
     }
     @Test
     public void test()
     {
         Assert.assertEquals(dataInfo.expected, BitwiseUtil.lowestSetBitIndex(dataInfo.val));
     }
 }
