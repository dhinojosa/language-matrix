export function multimax(arr) {
    return multimaxInternal(arr, 0);
}

function multimaxInternal(arr, acc) {
    if (arr === undefined || arr.length === 0) {
        return acc;
    } else if (Array.isArray(arr[0])) {
        let before = multimaxInternal(arr[0], acc)
        let after = multimaxInternal(arr.slice(1), acc)
        if (before >= after) return before;
        else return after;
    } else {
        if (arr[0] > acc) return multimaxInternal(arr.slice(1), arr[0])
        else return multimaxInternal(arr.slice(1), acc)
    }
}
