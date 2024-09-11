import React from "react";
import { Avatar, Typography, Paper, Grid, Tabs, Tab, Box } from "@mui/material";
import { styled } from "@mui/system";
import StarIcon from "@mui/icons-material/Star";

const Root = styled(Paper)(({ theme }) => ({
    padding: theme.spacing(3),
    maxWidth: 600,
    margin: "auto",
    marginTop: theme.spacing(5),
}));

const StyledAvatar = styled(Avatar)(({ theme }) => ({
    width: theme.spacing(12),
    height: theme.spacing(12),
    margin: theme.spacing(2),
}));

const CompanyName = styled(Typography)({
    fontWeight: "bold",
    fontSize: "24px",
});

const Details = styled(Grid)(({ theme }) => ({
    marginTop: theme.spacing(2),
    display: "flex",
    justifyContent: "space-between",
}));

const Rating = styled(Grid)({
    display: "flex",
    alignItems: "center",
});

const Location = styled(Grid)({
    display: "flex",
    alignItems: "center",
});

const TabContent = styled(Box)(({ theme }) => ({
    marginTop: theme.spacing(2),
}));

function CompanyProfile() {
    const [value, setValue] = React.useState(0);

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    const company = {
        image: "/default-company.png",
        name: "Tech Solutions Inc.",
        rating: 4.5,
        location: "New York, NY",
    };

    return (
        <Root>
            <Grid container alignItems="center" justifyContent="center">
                <StyledAvatar src={company.image} />
                <CompanyName>{company.name}</CompanyName>
            </Grid>
            <Details container>
                <Rating item>
                    <StarIcon color="secondary" />
                    <Typography>{company.rating}</Typography>
                </Rating>
                <Location item>
                    <Typography>{company.location}</Typography>
                </Location>
            </Details>
            <Tabs value={value} onChange={handleChange} centered>
                <Tab label="About Us" />
                <Tab label="JobPosts" />
                <Tab label="Reviews" />
            </Tabs>
            <TabContent>
                {value === 0 && <Typography>About Us content goes here.</Typography>}
                {value === 1 && <Typography>JobPosts content goes here.</Typography>}
                {value === 2 && <Typography>Reviews content goes here.</Typography>}
            </TabContent>
        </Root>
    );
}

export default CompanyProfile;
