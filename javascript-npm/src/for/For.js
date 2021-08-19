export function iterateWithOf(original) {
    let result = [];
    for (let x of original) {
        result.push(parseInt(x) + 3);
    }
    return result;
}

export function iterateWithIn(array) {
    const result = []
    for (let a in array) {
        result.push(a + "!");
    }
    return result;
}
