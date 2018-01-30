package gxa.entity;

public class Machine {
	public String mno;
	public String mname;
	public String mtype;
	public String mdesc;
	public String ano;
	public int x;
	public int y;

	public Machine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Machine(String mno, String mname, String mtype, String mdesc,
			String ano, int x, int y) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.mtype = mtype;
		this.mdesc = mdesc;
		this.ano = ano;
		this.x = x;
		this.y = y;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public String getMdesc() {
		return mdesc;
	}

	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
}
