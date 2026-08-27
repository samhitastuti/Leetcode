#include <stdio.h>
double findMaxAverage(int* nums, int numsSize, int k) {
    int i;
    double sum = 0;

    // First window
    for (i = 0; i < k; i++) {
        sum += nums[i];
    }

    double maxSum = sum;

    // Sliding window
    for (i = k; i < numsSize; i++) {
        sum += nums[i] - nums[i - k];
        if (sum > maxSum) {
            maxSum = sum;
        }
    }

    return maxSum / k;
}