<template>
    <div>
        <div class="card card-default">
            <div class="card-header">
                <div class="float-left">
                    Latest activity in Wikipedia (/api/latest_wiki_entries)
                </div>
                <div class="float-right">
                    <button type="button" class="btn btn-primary" v-on:click="getEntries"><span class="glyphicon glyphicon-refresh"></span> Refresh</button>
                </div>
            </div>

            <div class="card-body" style="padding:0rem;">
                <!-- Loading entries -->
                <p class="mb-0" v-if="entries.length === 0" style="padding:1.25rem;">
                    Loading data...
                </p>

                <!-- Wikipedia entries Tokens -->
                <table class="table table-striped table-hover mb-0" v-if="entries.length > 0">
                    <thead>
                        <tr>
                            <th width=15%>Event</th>
                            <th width=35%>Item</th>
                            <th width=20%>User</th>
                            <th width=30%>Link</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr v-for="entry in entries">
                            <!-- Client Name -->
                            <td style="vertical-align: middle;">
                                {{ entry.event }}
                            </td>
                            <td style="vertical-align: middle;">
                                {{ entry.item }}
                            </td>
                            <td style="vertical-align: middle;">
                                {{ entry.username }}
                            </td>
                            <td style="vertical-align: middle;">
                                <a :href="entry.link"> {{ entry.link }}</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        /*
         * The component's data.
         */
        data() {
            return {
                entries: [],
            };
        },

        /**
         * Prepare the component (Vue 1.x).
         */
        ready() {
            this.prepareComponent();
        },

        /**
         * Prepare the component (Vue 2.x).
         */
        mounted() {
            this.prepareComponent();
        },
        methods: {
            /**
             * Prepare the component.
             */
            prepareComponent() {
                this.getEntries();
            },

            /**
             * Get all of the personal access tokens for the user.
             */
            getEntries() {
                axios.get('api/latest_wiki_entries')
                        .then(response => { 
                            this.entries = response.data.slice(0,10);
                            this.entries.forEach(entry => {
                                for (var key in entry) {
                                    if(entry[key][0] == '\"') {
                                        entry[key] = entry[key].substring(1, entry[key].length - 1);
                                    }
                                }
                            });
                        });
            },
        }
    }
</script>
