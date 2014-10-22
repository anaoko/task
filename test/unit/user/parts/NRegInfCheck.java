package unit.user.parts;

import static org.junit.Assert.*;

import org.junit.Test;

import user.parts.RegInfCheck;

public class NRegInfCheck {

	@Test
	public void ncheckName() {
		RegInfCheck ch = new RegInfCheck();

		ch.checkName("0123456789");
		assertEquals("",ch.getErrMsg());
	}

	@Test
	public void ncheckName2() {
	RegInfCheck ch = new RegInfCheck();

	ch.checkName("あいうえおかきくけこ");
	assertEquals("",ch.getErrMsg());
	}

	@Test
	public void ncheckName3() {
	RegInfCheck ch = new RegInfCheck();

	ch.checkName("01234567890");
	assertEquals("名前は10桁以内で入力してください。<br />",ch.getErrMsg());
	}

	@Test
	public void ncheckName4() {
	RegInfCheck ch = new RegInfCheck();

	ch.checkName("あいうえおかきくけこさ");
	assertEquals("名前は10桁以内で入力してください。<br />",ch.getErrMsg());
	}

	@Test
	public void checkAge() {
		RegInfCheck ch = new RegInfCheck();

		ch.checkAge("16");
		assertEquals("",ch.getErrMsg());
	}
	@Test
	public void checkAge2() {
		RegInfCheck ch = new RegInfCheck();

		ch.checkAge("60");
		assertEquals("",ch.getErrMsg());
	}
	@Test
	public void checkAge3() {
		RegInfCheck ch = new RegInfCheck();

		ch.checkAge("15");
		assertEquals("年齢は(16-60)の範囲で入力してください。<br />",ch.getErrMsg());
	}
	@Test
	public void checkAge4() {
		RegInfCheck ch = new RegInfCheck();

		ch.checkAge("61");
		assertEquals("年齢は(16-60)の範囲で入力してください。<br />",ch.getErrMsg());
	}
	@Test
	public void checkAge5() {
		RegInfCheck ch = new RegInfCheck();

		ch.checkAge("１６");
		assertEquals("年齢は数値(半角)で入力してください。<br />",ch.getErrMsg());
	}
	@Test
	public void checkAge6() {
		RegInfCheck ch = new RegInfCheck();

		ch.checkAge("あいうえお");
		assertEquals("年齢は数値(半角)で入力してください。<br />年齢は(16-60)の範囲で入力してください。<br />",ch.getErrMsg());
	}
	@Test
	public void checkAge7() {
		RegInfCheck ch = new RegInfCheck();

		ch.checkAge("16あいうえお");
		assertEquals("年齢は数値(半角)で入力してください。<br />年齢は(16-60)の範囲で入力してください。<br />",ch.getErrMsg());
	}
	@Test
	public void checkId() {
		RegInfCheck ch = new RegInfCheck();

		ch.checkId("999");
		assertEquals("",ch.getErrMsg());
	}
	@Test
	public void checkId2() {
		RegInfCheck ch = new RegInfCheck();

		ch.checkId("1000");
		assertEquals("登録可能なID（999）を超えています。管理者に問い合わせてください。<br />",ch.getErrMsg());
	}
}
