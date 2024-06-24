package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalTest {

	@Test
	void test() {
		Cal C =new Cal();
		float r=C.Calc(1,2,3);
		assertEquals(2,r);


}
}
