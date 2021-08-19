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
});
