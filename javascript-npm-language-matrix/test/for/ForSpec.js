import {strict as assert} from 'assert';
import {iterateWithOf, iterateWithIn} from '../../src/for/For.js';

describe('for loop', () => {
    it('should iterate all the values using of', () => {
        const result = iterateWithOf(["10", "20", "30"]);
        assert.deepEqual(result, [13, 23, 33]);
    });
    it("has a for in, that will actually iterateWithOf the properties, in this case the indices", () => {
        assert.deepEqual(iterateWithIn(["Foo", "Bar", "Baz"]), ["0!", "1!", "2!"])
    });
});
