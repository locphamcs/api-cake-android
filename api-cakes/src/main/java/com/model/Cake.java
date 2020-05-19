package com.model;

public class Cake {
	private int stt;
	private int ma_banh;
	private String ten_banh;
	private String loai_banh;
	private String thoi_gian;
	private String khau_phan;
	private String do_kho;
	private String nguyen_lieu;
	private String cach_lam;
	private String link_anh;
	public String getLink_anh() {
		return link_anh;
	}
	public void setLink_anh(String link_anh) {
		this.link_anh = link_anh;
	}
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public int getMa_banh() {
		return ma_banh;
	}
	public void setMa_banh(int ma_banh) {
		this.ma_banh = ma_banh;
	}
	public String getTen_banh() {
		return ten_banh;
	}
	public void setTen_banh(String ten_banh) {
		this.ten_banh = ten_banh;
	}
	public String getLoai_banh() {
		return loai_banh;
	}
	public void setLoai_banh(String loai_banh) {
		this.loai_banh = loai_banh;
	}
	public String getThoi_gian() {
		return thoi_gian;
	}
	public void setThoi_gian(String thoi_gian) {
		this.thoi_gian = thoi_gian;
	}
	public String getKhau_phan() {
		return khau_phan;
	}
	public void setKhau_phan(String khau_phan) {
		this.khau_phan = khau_phan;
	}
	public String getDo_kho() {
		return do_kho;
	}
	public void setDo_kho(String do_kho) {
		this.do_kho = do_kho;
	}
	public String getNguyen_lieu() {
		return nguyen_lieu;
	}
	public void setNguyen_lieu(String nguyen_lieu) {
		this.nguyen_lieu = nguyen_lieu;
	}
	public String getCach_lam() {
		return cach_lam;
	}
	public void setCach_lam(String cach_lam) {
		this.cach_lam = cach_lam;
	}
	@Override
	public String toString() {
		return "Cake [stt=" + stt + ", ma_banh=" + ma_banh + ", ten_banh=" + ten_banh + ", loai_banh=" + loai_banh
				+ ", thoi_gian=" + thoi_gian + ", khau_phan=" + khau_phan + ", do_kho=" + do_kho + ", nguyen_lieu="
				+ nguyen_lieu + ", cach_lam=" + cach_lam + ", link_anh=" + link_anh + "]";
	}
	public Cake() {
		super();
	}

}
