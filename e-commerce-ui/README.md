# e-commerce-ui

## Project setup

```
npm install
```

### Compiles and hot-reloads for development

```
npm run serve
```

### Compiles and minifies for production

```
npm run build
```

### Lints and fixes files

```
npm run lint
```

### Customize configuration

See [Configuration Reference](https://cli.vuejs.org/config/).

## VUE components

- The `template` tag contains the HTML of the component.
- The `script` tag contains the code defining the custom behavior of the component.
- The `style` tag houses the CSS of the component.
- `src/components` and `src/views` contain all our components.

## Folder structure

- `public`: This contains the main HTML file of our project.
- `src/assets`: This stores the media files like images, logos, and so on.
- `src/components`: This stores all the reusable components of our project. These components are not unique to some specific route.
  Apart from this, we have some additional important files:

- `App.vue`: The root component of our project.
- `main.js`: The starting point of our project. Here we import our root component `App.vue`, our router file `index`.js, and the `createApp` method. After this, we mount our root - component to the DOM using the following statement:
    ```js
    import { createApp } from "vue";
    import App from "./App.vue";

    createApp(App).mount("#app");

    ```
