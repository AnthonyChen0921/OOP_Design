/*
    3SumClosest.cpp
    Author: @Anthony Chen
    Email: chenerdong@wustl.edu
    Date: Sep 2, 2022
*/

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>


using namespace std;


int threeSumClosest(vector<int>& nums, int target){

}

// binary search array
int binarySearch(vector<int>& nums, int target){
    int left = 0;
    int right = nums.size() - 1;
    while(left <= right){
        int mid = left + (right - left) / 2;
        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid] < target){
            left = mid + 1;
        }
        else{
            right = mid - 1;
        }
    }
    return -1;
}
// use bucket sort to sort the array
void bucketSort(vector<int>& nums){
    // find the max and min value in the array
    int max = nums[0];
    int min = nums[0];
    for(int i = 0; i < nums.size(); i++){
        if(nums[i] > max){
            max = nums[i];
        }
        if(nums[i] < min){
            min = nums[i];
        }
    }
    // create a bucket array
    int bucketSize = max - min + 1;
    vector<int> bucket(bucketSize, 0);
    // put the value in the array into the bucket
    for(int i = 0; i < nums.size(); i++){
        // the index of the bucket
        bucket[nums[i] - min]++;
    }
    // put the value back to the array
    int index = 0;
    // traverse the bucket
    for(int i = 0; i < bucketSize; i++){
        while(bucket[i] > 0){
            // put the value back to the array
            nums[index++] = i + min;
            bucket[i]--;
        }
    }
}
int main() {
    vector<int> nums = {-1, 2, 1, -4};
    cout << threeSumClosest(nums, 1) << endl;
    return 0;
}