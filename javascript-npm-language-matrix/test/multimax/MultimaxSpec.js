import {strict as assert} from 'assert';
import {multimax} from '../../src/challenges/Multimax.js';

describe("Multimax should find the maximum of the array, " +
    "with the possibility that it can be a multidimensional array", () => {
    it("should return a null when it is empty", () => {
        assert.deepEqual(multimax([]), 0);
    });
    it("should return a 1 when the array has one element of one", () => {
        assert.deepEqual(multimax([1]), 1);
    });
    it("should return a 5 when the array has two elements, a one and a 5", () => {
        assert.deepEqual(multimax([1, 5]), 5);
    });
    it("should return a 10 when the array has two elements, a one and a [10, 5]", () => {
        assert.deepEqual(multimax([1, [10,5]]), 10);
    });
    it("should return a 10 when the array has three elements, a one, a [10, 5], and a [10, 6]", () => {
        assert.deepEqual(multimax([1, [10,5], [10, 6]]), 10);
    });
    it("should return a 101 when the array has three elements, a one, a [10, 5], and a [10, 101]", () => {
        assert.deepEqual(multimax([1, [10,5], [10, 101]]), 101);
    });
    it("should return a 2001 with this long nested array", () => {
        assert.deepEqual(multimax([1, [10,5,-1], [10, 101], 2000, [2001, 0]]), 2001);
    });
    it("should return a zero if there are heavily nested arrays", () => {
        assert.deepEqual(multimax([[[], []], []]), 0);
    });
});
