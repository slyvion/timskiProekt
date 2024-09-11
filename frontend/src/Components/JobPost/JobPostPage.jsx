import { useEffect, useState } from "react";
import JobPostFilter from "./JobPostFilter.jsx";
import JobPost from "./JobPost.jsx";
import AppAppBar from "../AppAppBar.jsx";

export default function JobPostPage() {

    const [jobPosts, setJobPosts] = useState([]);

    const [loading, setLoading] = useState(true);

    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchJobPosts = async () => {
            try {

                const response = await fetch("http://localhost:8080/jobposts");

                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }

                const data = await response.json();

                setJobPosts(data);
            } catch (err) {
                setError(err.message);
            } finally {
                setLoading(false);
            }
        };

        fetchJobPosts();
    }, []);

    return (
        <div>
            <AppAppBar />
            <JobPostFilter />

            {loading ? (
                <p>Loading...</p>
            ) : error ? (
                <p>Error: {error}</p>
            ) : (
                <span>
          {jobPosts.map((job) => (
              <JobPost key={job.id} job={job} />
          ))}
        </span>
            )}
        </div>
    );
}
