package com.inditex;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.code.beanmatchers.BeanMatchers;
import com.google.code.beanmatchers.ValueGenerator;
import com.inditex.dto.ErrorDTO;
import com.inditex.dto.PriceDTO;
import com.inditex.entity.PricesEntity;

@RunWith(SpringRunner.class)
public class InditexTrialUnitTests {

	@Test
    public void testPriceDTO() {
        assertThat(PriceDTO.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanHashCode(),
                hasValidBeanEquals(),
                hasValidBeanToString()
        ));
    }
	
	@Test
    public void testErrorDTO() {
        assertThat(ErrorDTO.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanHashCode(),
                hasValidBeanEquals(),
                hasValidBeanToString()
        ));
    }
	
	@Test
    public void testPricesEntity() {
		
		BeanMatchers.registerValueGenerator(new ValueGenerator<LocalDateTime>() {
	        public LocalDateTime generate() {
	            return LocalDateTime.now();
	        }
	    }, LocalDateTime.class);
		
        assertThat(PricesEntity.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanHashCode(),
                hasValidBeanEquals(),
                hasValidBeanToString()
        ));
    }

}
