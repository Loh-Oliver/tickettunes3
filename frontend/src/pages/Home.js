import { useRef, Fragment } from "react";
import NavBar from "../components/navigation/NavBar";
import FieldsRow from "../components/form/FieldsRow";
import SearchBox from "../components/home/SearchBox";
import Cards from "../components/home/Cards";
import Button from "@mui/material/Button";
import * as React from 'react';
import Typography from "@mui/material/Typography";
import CssBaseline from '@mui/material/CssBaseline';
import Footer from "../components/footer/Footer";
import Container from "@mui/material/Container"
import Heropage from "../assets/heropage.png";
import KeyboardArrowDownOutlinedIcon from '@mui/icons-material/KeyboardArrowDownOutlined';
import IconButton from "@mui/material/IconButton";

const Home = () => {
    const eventslist = useRef(null);

    function scrollToSection(ref) {
        if (ref.current) {
            ref.current.scrollIntoView({ behavior: 'smooth' });
        }
    }

    return (
        <Fragment>
            <CssBaseline />
            <NavBar/>

            <Container
            style={{
                position: 'relative', // Set the container's position to relative
                maxWidth: '100%', // Ensure the container spans the entire width
                padding: 0, // Remove any default padding
            }}
            >
            {/* Image */}
            <img
            src={Heropage}
            alt="Background"
            style={{ width: '100%', height: '550px' }}
            />

            <div
            style={{
                position: 'absolute', // Set the overlay elements' position to absolute
                top: 0, // Position from the top edge
                left: 0, // Position from the left edge
                width: '100%', // Match the width of the container
                height: '100%', // Match the height of the container
                alignItems: 'center',
                justifyContent: 'center',
            }}
            >

            <FieldsRow>
            <Container>
                <Typography variant="h2" fontWeight="bold" color="white" textAlign="center">Dance with the rhythm, <br/>immerse in the melody.</Typography>
            </Container>
            </FieldsRow>

            <FieldsRow>
                <SearchBox/>
            </FieldsRow>

            <FieldsRow>
                <Typography color="white">Scroll down to discover upcoming events</Typography>
            </FieldsRow>

            <FieldsRow>
            <IconButton>
                <KeyboardArrowDownOutlinedIcon fontSize="large" style={{color: "white"}}
                onClick={() => scrollToSection(eventslist)}
                />
            </IconButton>
            </FieldsRow>
            </div>
            </Container>


            <FieldsRow>
            <Typography a ref={eventslist} variant="h3" gutterBottom sx={{fontWeight: "bold"}}>
                Upcoming Events
            </Typography>
            </FieldsRow>

            {/* cards */}
            <Cards/>

            <FieldsRow>
                <Button variant="outlined" size="large">
                    Load More
                </Button>
            </FieldsRow>

            <Footer/>
        </Fragment>
    );
};

export default Home;