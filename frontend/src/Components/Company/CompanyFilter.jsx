import { TextField, FormControl, InputLabel, Select, MenuItem, Grid, Button, Box } from '@mui/material';
import CountrySelect from '../Login/CountrySelect.jsx';

export default function CompanyFilter() {
    return (
        <Box sx={{ width: '100%', backgroundColor: '#fff', padding: '16px' }}>
            <Grid container spacing={2} alignItems="center" justifyContent="center">
                <Grid item xs={12} sm={2}>
                    <TextField label="Name" variant="outlined" fullWidth />
                </Grid>
                <Grid item xs={12} sm={2}>
                    <CountrySelect />
                </Grid>
                <Grid item xs={12} sm={1}>
                    <FormControl variant="outlined" fullWidth>
                        <InputLabel>Rating</InputLabel>
                        <Select label="Rating">
                            <MenuItem value={1}>1</MenuItem>
                            <MenuItem value={2}>2</MenuItem>
                            <MenuItem value={3}>3</MenuItem>
                            <MenuItem value={4}>4</MenuItem>
                            <MenuItem value={5}>5</MenuItem>
                        </Select>
                    </FormControl>
                </Grid>
                <Grid item xs={12} sm={1}>
                    <Button variant="contained" color="primary" fullWidth>
                        Filter
                    </Button>
                </Grid>
            </Grid>
        </Box>
    );
}
