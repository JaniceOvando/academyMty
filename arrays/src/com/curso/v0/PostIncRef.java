package com.curso.v0;

public class PostIncRef {

	static int[] cambiar(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			arr[i] *= 2;
		return new int[] { -1, -1, -1 };
	}

	public static void main(String[] args) {
		int[] nums = { 5, 10, 15 };
		
		System.out.println(nums[0] + " " + nums[2]);
		

		nums = cambiar(nums);
		
		
		System.out.println(nums[0] + " " + nums[2]);
		
		
	}

}