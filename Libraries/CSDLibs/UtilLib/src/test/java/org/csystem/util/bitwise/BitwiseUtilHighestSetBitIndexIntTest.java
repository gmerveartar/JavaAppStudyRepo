 package org.csystem.util.bitwise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

 @RunWith(Parameterized.class)
 public class BitwiseUtilHighestSetBitIndexIntTest {
     static class DataInfo {
         int val;
         int expected;
         public DataInfo(int val,int expected) {
             this.val = val;
             this.expected = expected;
         }
     }
     public BitwiseUtilHighestSetBitIndexIntTest(DataInfo dataInfo) {
         this.dataInfo = dataInfo;
     }

     public DataInfo dataInfo;
     @Parameterized.Parameters
     public static Collection<DataInfo> createData()
     {
         return List.of(new DataInfo(10, 3),
                 new DataInfo(8, 3),
                 new DataInfo(0, -1)
         );
     }
     @Test
     public void test()
     {
         Assert. assertEquals(dataInfo.expected, BitwiseUtil.highestSetBitIndex(dataInfo.val));
     }
 }
