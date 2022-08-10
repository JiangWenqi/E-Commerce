import { createRouter, createWebHistory } from "vue-router";
import HomepageView from "../views/HomepageView";
import AddCategory from "../views/category/AddCategory";
import CategoryView from "../views/category/CategoryView";
import EditCategory from "../views/category/EditCategory";
import AddProduct from "../views/product/AddProduct";
import ProductView from "../views/product/ProductView";
import EditProduct from "../views/product/EditProduct";
import ShowDetails from "../views/product/ShowDetails";
import SignupView from "../views/SignupView";
import SignInView from "../views/SignInView";
import WishList from "../views/product/WishList";
import CartView from "../views/cart/CartView";
import PaymentSuccess from "../views/payment/PaymentSuccess";
import PaymentFailed from "../views/payment/PaymentFailed";
import CheckoutView from "../views/checkout/CheckoutView";
import OrderHistory from "../views/order/OrderHistory";
import OrderDetails from "../views/order/OrderDetails";

const routes = [
  {
    path: "/",
    name: "Home",
    component: HomepageView,
  },
  {
    path: "/admin/category/add",
    name: "AddCategory",
    component: AddCategory,
  },
  {
    path: "/admin/category",
    name: "AdminCategory",
    component: CategoryView,
  },
  {
    path: "/admin/category/:id",
    name: "EditCategory",
    component: EditCategory,
  },
  {
    path: "/admin/product/add",
    name: "AddProduct",
    component: AddProduct,
  },
  {
    path: "/admin/product",
    name: "AdminProduct",
    component: ProductView,
  },
  {
    path: "/admin/product/:id",
    name: "EditProduct",
    component: EditProduct,
  },
  {
    path: "/product/show/:id",
    name: "ShowDetails",
    component: ShowDetails,
  },
  {
    path: "/signup",
    name: "Signup",
    component: SignupView,
  },
  {
    path: "/signIn",
    name: "SignIn",
    component: SignInView,
  },
  {
    path: "/wishlist",
    name: "WishList",
    component: WishList,
  },
  {
    path: "/cart",
    name: "Cart",
    component: CartView,
  },

  {
    path: "/payment/success",
    name: "PaymentSuccess",
    component: PaymentSuccess,
  },
  {
    path: "/payment/failed",
    name: "PaymentFailed",
    component: PaymentFailed,
  },
  {
    path: "/checkout",
    name: "Checkout",
    component: CheckoutView,
  },
  {
    path: "/orders",
    name: "OrderHistory",
    component: OrderHistory,
  },
  {
    path: "/order/:id",
    name: "OrderDetails",
    component: OrderDetails,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
