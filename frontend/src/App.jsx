
import CssBaseline from '@mui/material/CssBaseline';
import Features from "./Components/HomePage/Features.jsx";
import {Divider} from "@mui/material";
import Highlights from "./Components/HomePage/Highlights.jsx";
import Hero from "./Components/HomePage/Hero.jsx";
import Footer from "./Components/HomePage/Footer.jsx";
import AppAppBar from "./Components/AppAppBar.jsx";


function App() {

  return (
    <>
        <CssBaseline />
        <AppAppBar />
        <Hero />
        <Features />
        <Highlights />
        <Footer />

    </>
  )
}

export default App
