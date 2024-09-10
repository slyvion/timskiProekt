import React from "react";
import { Avatar, Typography, Paper, Grid, Tabs, Tab, Box } from "@mui/material";
import { styled } from "@mui/system";

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

const UserName = styled(Typography)({
    fontWeight: "bold",
    fontSize: "24px",
});

const Country = styled(Typography)(({ theme }) => ({
    marginTop: theme.spacing(1),
    color: theme.palette.text.secondary,
}));

const TabContent = styled(Box)(({ theme }) => ({
    marginTop: theme.spacing(2),
}));

function UserProfile() {
    const [value, setValue] = React.useState(0);

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    const user = {
        image: "/default-user.png", // Default image path
        name: "John Doe",
        country: "United States",
    };

    return (
        <Root>
            <Grid container alignItems="center" justifyContent="center">
                <StyledAvatar src={user.image} />
                <UserName>{user.name}</UserName>
                <Country>{user.country}</Country>
            </Grid>
            <Tabs value={value} onChange={handleChange} centered>
                <Tab label="Reviews" />
                <Tab label="Saved JobPosts" />
            </Tabs>
            <TabContent>
                {value === 0 && <Typography>Reviews content goes here.</Typography>}
                {value === 1 && <Typography>Saved JobPosts content goes here.</Typography>}
            </TabContent>
        </Root>
    );
}

export default UserProfile;
