import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Example_2
    {

		private static final int test_size = 10;

        private ArrayList<Integer> prepareSource()
        {
            ArrayList<Integer> source = new ArrayList<Integer>(test_size);

            for (int i = 0; i < test_size; i++)
            {
                source.add(i);
            }
            return source;
        }
        
		private List<Integer> prepareExpectedResult(int startPoint, int length) {
			ArrayList<Integer> source = new ArrayList<Integer>(test_size);

            for (int i = 0; i < test_size; i++)
            {
            	if (i < startPoint || i > startPoint+length)
            		source.add(i);
            }
            return source;
		}

        @Test
        public void GetRangeCreatesNewListWithElementWithinIndexRangeInBaseList()
        {
            //given 
            List<Integer> l = prepareSource();

            for (int startPoint = 0; startPoint <= l.size() + 1; startPoint++)
            {
                int maxLenght = l.size() - startPoint + 1;
                for (int length = 0; length < maxLenght; length++ )
                {
                    List<Integer> expectedResult = prepareExpectedResult(startPoint,length);
                    //when
                    List<Integer> result = l.subList(startPoint,length);
                    //then
                    Assert.assertEquals(expectedResult,result);
                }
            }
        }


    }

