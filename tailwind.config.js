/** @type {import('tailwindcss').Config} */

// const isProd = process.env.NODE_ENV == 'production'
// Production dir 
// ["./public/js/main.js"]

module.exports = {
  // in prod look at shadow-cljs output file in dev look at runtime,
  // which will change files that are actually compiled; 
  // postcss watch should be a whole lot faster
  content: ["./resources/public/js/compiled/cljs-runtime/*.js"],
  theme: {
    extend: {},
  },
  plugins: [],
}