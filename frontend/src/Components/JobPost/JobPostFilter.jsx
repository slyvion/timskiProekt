import { TextField, FormControl, InputLabel, Select, MenuItem, Grid, Button, Box } from '@mui/material';

export default function JobPostFilter() {
    return (
        <Box sx={{ width: '100%', backgroundColor: '#fff', padding: '16px' }}>
            <Grid container spacing={2} alignItems="center" justifyContent="center">
                <Grid item xs={12} sm={2}>
                    <TextField label="Company" variant="outlined" fullWidth />
                </Grid>
                <Grid item xs={12} sm={2}>
                    <TextField label="Title" variant="outlined" fullWidth />
                </Grid>
                <Grid item xs={12} sm={2}>
                    <FormControl fullWidth variant="outlined">
                        <InputLabel>Type</InputLabel>
                        <Select label="Type">
                            <MenuItem value="On Site">On Site</MenuItem>
                            <MenuItem value="Hybrid">Hybrid</MenuItem>
                            <MenuItem value="Remote">Remote</MenuItem>
                        </Select>
                    </FormControl>
                </Grid>
                <Grid item xs={12} sm={2}>
                    <FormControl fullWidth variant="outlined">
                        <InputLabel>Employment Type</InputLabel>
                        <Select label="Employment Type">
                            <MenuItem value="Full-Time">Full-Time</MenuItem>
                            <MenuItem value="Part-Time">Part-Time</MenuItem>
                            <MenuItem value="Intern">Intern</MenuItem>
                        </Select>
                    </FormControl>
                </Grid>
                <Grid item xs={12} sm={1}>
                    <Button variant="contained" color="primary" >
                        Filter
                    </Button>
                </Grid>
            </Grid>
        </Box>
    );
}
