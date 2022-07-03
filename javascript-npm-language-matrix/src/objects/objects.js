const o = {
    firstName: "Samuel",
    lastName: "Clemens",
    fullName: function () {
        return this.firstName + " " + this.lastName;
    }
};

console.log(o.fullName()); //Samuel Clemens
