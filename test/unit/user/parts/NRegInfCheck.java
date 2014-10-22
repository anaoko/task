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

	ch.checkName("��������������������");
	assertEquals("",ch.getErrMsg());
	}

	@Test
	public void ncheckName3() {
	RegInfCheck ch = new RegInfCheck();

	ch.checkName("01234567890");
	assertEquals("���O��10���ȓ��œ��͂��Ă��������B<br />",ch.getErrMsg());
	}

	@Test
	public void ncheckName4() {
	RegInfCheck ch = new RegInfCheck();

	ch.checkName("����������������������");
	assertEquals("���O��10���ȓ��œ��͂��Ă��������B<br />",ch.getErrMsg());
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
		assertEquals("�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />",ch.getErrMsg());
	}
	@Test
	public void checkAge4() {
		RegInfCheck ch = new RegInfCheck();

		ch.checkAge("61");
		assertEquals("�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />",ch.getErrMsg());
	}
	@Test
	public void checkAge5() {
		RegInfCheck ch = new RegInfCheck();

		ch.checkAge("�P�U");
		assertEquals("�N��͐��l(���p)�œ��͂��Ă��������B<br />",ch.getErrMsg());
	}
	@Test
	public void checkAge6() {
		RegInfCheck ch = new RegInfCheck();

		ch.checkAge("����������");
		assertEquals("�N��͐��l(���p)�œ��͂��Ă��������B<br />�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />",ch.getErrMsg());
	}
	@Test
	public void checkAge7() {
		RegInfCheck ch = new RegInfCheck();

		ch.checkAge("16����������");
		assertEquals("�N��͐��l(���p)�œ��͂��Ă��������B<br />�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />",ch.getErrMsg());
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
		assertEquals("�o�^�\��ID�i999�j�𒴂��Ă��܂��B�Ǘ��҂ɖ₢���킹�Ă��������B<br />",ch.getErrMsg());
	}
}
