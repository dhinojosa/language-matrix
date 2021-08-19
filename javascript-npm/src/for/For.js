export function iterate(original) {
    let result = [];
    for (let x of original) {
        result.push(parseInt(x) + 3);
    }
    return result;
}
