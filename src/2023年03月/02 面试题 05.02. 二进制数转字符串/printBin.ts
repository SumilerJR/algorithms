function printBin(num: number): string {
    const ans: string = num.toString(2);
    return ans.length > 32 ? "ERROR" : ans;
};