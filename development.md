# Re-frame app
:)

# Development Mode  
To enable development mode, we use the `npm-run-all` library, which allows us to run any command with the `:watch` suffix.  

### Requirements  
- `shadow-cljs`  
- `tailwindcss`  

Check `package.json` for more details.  

To start the development mode, run:  
```sh
npm run watch
```

---

# Release Build  
For generating a release build, we also use the `npm-run-all` library, executing commands with the `:release` suffix.  

### Requirements  
- `shadow-cljs`  
- `tailwindcss`  

Refer to `package.json` for more details.  

To create a release build, run:  
```sh
npm run release
```

---

# Tailwind Configuration  
To properly configure TailwindCSS:  

1. Set the JavaScript output directory where `shadow-cljs` builds its files.  
2. Update the `content` key in `tailwind.config.js` to include the correct paths.  
3. The Tailwind command defined in `package.json` specifies `input.css` and `output.css`.  
4. Ensure that `output.css` is in the same directory as `index.html`.  

For more details, check the official TailwindCSS documentation:  
- [Tailwind CLI Installation](https://tailwindcss.com/docs/installation/tailwind-cli)  


# Re-frame db structure