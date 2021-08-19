import { strict as assert } from 'assert';
import {iterate} from '../../src/for/For.js';

describe('for loop', () => {
    it('should iterate through items just like in java', () => {
        const result = iterate(["10", "20", "30"]);
        assert.deepEqual(result, [13, 23, 33]);
    });
});
