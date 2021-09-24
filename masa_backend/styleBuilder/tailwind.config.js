const theme = require("tailwindcss/defaultTheme");

module.exports = {
        purge: ["./../src/**/*.jsp","./../src/**/*.js"],
        darkMode: false, // or 'media' or 'class'
        theme: { spacing: { ...theme.spacing, 101: "25.25rem" }, extend: {} },
        variants: {
                extend: {},
        },
        plugins: [],
};
