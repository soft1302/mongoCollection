package com;

public class Datas {
	private int _id;
	private float x;
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	@Override
	public String toString() {
		return "Datas [_id=" + _id + ", x=" + x + "]";
	}
	
}
